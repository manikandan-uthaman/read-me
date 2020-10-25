import { Component, ElementRef, Input, OnInit } from '@angular/core';
import { Book } from 'src/app/model/book';
import { ColorScheme } from 'src/app/model/color-schemes';
import { BookSearchRequest } from 'src/app/model/search-request';
import { SearchResponse } from 'src/app/model/search-response';
import { BookService } from 'src/app/services/book.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit {

  bookList: Array<Book> = [];
  rows: Array<Array<Book>>;
  isLoading = false;

  @Input() loadMoreOnScroll = true;
  @Input() pageTitle = 'Books List';
  @Input() searchRequest: BookSearchRequest = {
    pageNumber: 1,
    recordsPerPage: 10
  };

  totalNumberOfpages = 0;

  constructor(private _bookService: BookService) { }

  ngOnInit(): void {
    this.loadBooks();
  }

  loadBooks() {
    this.isLoading = true;
    setTimeout(() => {
      this._bookService.getBookList(this.searchRequest).subscribe((resp: SearchResponse) => {
        this.totalNumberOfpages = Math.ceil(resp.totalNumberOfElements / resp.resultsPerPage);
        if (this.totalNumberOfpages === this.searchRequest.pageNumber) {
          this.loadMoreOnScroll = false;
        }
        this.bookList.push(...resp.books);
        this.initializePage();
        this.isLoading = false;
      }, (error) => {
        this.isLoading = false;
        console.log('Something went wrong..');
      });
    }, 3000);
  }

  initializePage() {
    this.rows = [];
    const rowCount = Math.ceil(this.bookList.length / 3);
    let startIndex = 0;
    for (let index = 0; index < rowCount; index++, startIndex += 3) {
      this.rows.push(this.bookList.slice(startIndex, startIndex + 3));
    }
  }

  getColorScheme(rowNum, columnNum) {
    let sum = rowNum + columnNum;
    while (sum > 2) {
      sum = sum - 3;
    }
    if (sum === 0) {
      return ColorScheme.colorSchemeOrange;
    }
    if (sum === 1) {
      return ColorScheme.colorSchemeGreen;
    }
    if (sum === 2) {
      return ColorScheme.colorSchemeBlue;
    }
  }

  onScroll() {
    this.searchRequest.pageNumber = this.searchRequest.pageNumber + 1;
    this.loadBooks();
  }
}

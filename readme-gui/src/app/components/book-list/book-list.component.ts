import { Component, ElementRef, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from 'src/app/model/book';
import { ColorScheme } from 'src/app/model/color-schemes';
import { BookSearchRequest } from 'src/app/model/search-request';
import { SearchResponse } from 'src/app/model/search-response';
import { BookService } from 'src/app/services/book.service';
import { ToastrService } from 'src/app/services/toastr.service';

export interface BookListOptions {
  showHomeButton?: boolean;
  loadMoreOnScroll?: boolean;
  pageTitle?: string;
}

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit {

  bookList: Array<Book> = [];
  rows: Array<Array<Book>>;
  isLoading = false;

  @Input() options: BookListOptions = {
    showHomeButton: true,
    loadMoreOnScroll: true,
    pageTitle: 'Book List'
  };

  @Input() searchRequest: BookSearchRequest = {
    pageNumber: 1,
    recordsPerPage: 9
  };

  totalNumberOfpages = 0;

  constructor(private _bookService: BookService, private toastrService: ToastrService, private router: Router) { }

  ngOnInit(): void {
    this.loadBooks();
  }

  loadBooks() {
    this.isLoading = true;

    // introduced timeout to demonstrate spinner
    setTimeout(() => {
      this._bookService.getBookList(this.searchRequest).subscribe((resp: SearchResponse) => {
        this.totalNumberOfpages = Math.ceil(resp.totalNumberOfElements / resp.resultsPerPage);
        if (this.totalNumberOfpages === this.searchRequest.pageNumber) {
          this.options.loadMoreOnScroll = false;
        }
        this.bookList.push(...resp.books);
        this.initializePage();
        this.isLoading = false;
      }, (error) => {
        this.isLoading = false;
        this.options.loadMoreOnScroll = false;
        this.toastrService.showError('Something went wrong. Please try again later..');
        console.log(error);
        // Route to home if used as page
        if (this.options.showHomeButton) {
          this.router.navigate(['/home']);
        }
      });
    }, 1500);
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

  menuClickEvent(url: string) {
    this.router.navigate([url]);
  }

}

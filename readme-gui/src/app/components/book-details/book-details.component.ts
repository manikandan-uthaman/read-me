import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from 'src/app/model/book';
import { BookSearchRequest, FilterCriteria } from 'src/app/model/search-request';
import { BookService } from 'src/app/services/book.service';
import { ToastrService } from 'src/app/services/toastr.service';
import { BookListOptions } from '../book-list/book-list.component';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.scss']
})
export class BookDetailsComponent implements OnInit {

  bookId: number;
  bookDetails: Book;
  searchRequest: BookSearchRequest;
  options: BookListOptions;
  isMoreInfoLoading: boolean;
  constructor(private bookService: BookService, private toastrService: ToastrService,
              private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.bookId = params.id;
      this.bookService.getBookDetails(this.bookId)
      .subscribe(resp => {
        this.bookDetails = resp;
        this.searchRequest = {
          filterBy: FilterCriteria.AUTHOR,
          searchString: this.bookDetails.author.id.toString(),
          pageNumber: 1,
          recordsPerPage: 3
        };
        this.options = {
          showHomeButton: false,
          loadMoreOnScroll: false,
          pageTitle: 'More from the Author'
        };
      }, error => {
        this.toastrService.showError('Something went wrong. Please try again later..');
        console.log(error);
        this.router.navigate(['/home']);
      });
    });
  }

  menuClickEvent(url: string) {
    this.router.navigate([url]);
  }
}

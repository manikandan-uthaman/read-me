import { Component, ElementRef, OnInit } from '@angular/core';
import { Router } from '@angular/router';

export interface Author {
  id: number;
  name: string;
}
export interface Book {
  id: number;
  year: string;
  url: string;
  author: Author;
  title: string;
  price: number;
  rating: number;
}

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit {

  bookList: Array<Book>;
  rows: Array<Array<Book>>;
  loadMoreOnScroll = true;
  isLoading = false;
  colorSchemeOrange = {
    lightHex: '#ffb900',
    lightRgb: '255,185,0',
    darkHex: '#ff7730',
    darkRgb: '255,119,48'
  };
  colorSchemeBlue = {
    lightHex: '#2998ff',
    lightRgb: '41,152,255',
    darkHex: '#5643fa',
    darkRgb: '86,67,250'
  };
  colorSchemeGreen = {
    lightHex: '#7ed56f',
    lightRgb: '126,213,111',
    darkHex: '#28b485',
    darkRgb: '40,180,133'
  };
  constructor(private router: Router) { }

  ngOnInit(): void {
    this.bookList = [
      {
        id: 2,
        year: '2015',
        url: 'http://author.com',
        author: {
          id: 1,
          name: 'John Doe'
        },
        title: 'TIME MANAGEMENT',
        price: 100,
        rating: 3.5
      },
      {
        id: 3,
        year: '2018',
        url: 'http://author.com',
        author: {
          id: 2,
          name: 'Harry Graham Thornton'
        },
        title: 'The Big, White Bear',
        price: 312,
        rating: 4.7
      },
      {
        id: 4,
        year: '1993',
        url: 'http://author.com',
        author: {
          id: 3,
          name: 'Max Giovanna'
        },
        title: 'The Adventures of Anonymous',
        price: 430,
        rating: 2.8
      },
      {
        id: 5,
        year: '2003',
        url: 'http://author.com',
        author: {
          id: 4,
          name: 'Christy Lawson'
        },
        title: 'Fact versus Fiction',
        price: 120,
        rating: 3.3
      },
      {
        id: 6,
        year: '2003',
        url: 'http://author.com',
        author: {
          id: 7,
          name: 'Arisha Parks'
        },
        title: 'An exploration of Memes',
        price: 120,
        rating: 1.3
      }, {
        id: 2,
        year: '2015',
        url: 'http://author.com',
        author: {
          id: 1,
          name: 'John Doe'
        },
        title: 'TIME MANAGEMENT',
        price: 100,
        rating: 3.5
      },
      {
        id: 3,
        year: '2018',
        url: 'http://author.com',
        author: {
          id: 2,
          name: 'Harry Graham Thornton'
        },
        title: 'The Big, White Bear',
        price: 312,
        rating: 4.7
      },
      {
        id: 4,
        year: '1993',
        url: 'http://author.com',
        author: {
          id: 3,
          name: 'Max Giovanna'
        },
        title: 'The Adventures of Anonymous',
        price: 430,
        rating: 2.8
      },
      {
        id: 5,
        year: '2003',
        url: 'http://author.com',
        author: {
          id: 4,
          name: 'Christy Lawson'
        },
        title: 'Fact versus Fiction',
        price: 120,
        rating: 3.3
      },
      {
        id: 6,
        year: '2003',
        url: 'http://author.com',
        author: {
          id: 7,
          name: 'Arisha Parks'
        },
        title: 'An exploration of Memes',
        price: 120,
        rating: 1.3
      }, {
        id: 2,
        year: '2015',
        url: 'http://author.com',
        author: {
          id: 1,
          name: 'John Doe'
        },
        title: 'TIME MANAGEMENT',
        price: 100,
        rating: 3.5
      },
      {
        id: 3,
        year: '2018',
        url: 'http://author.com',
        author: {
          id: 2,
          name: 'Harry Graham Thornton'
        },
        title: 'The Big, White Bear',
        price: 312,
        rating: 4.7
      },
      {
        id: 4,
        year: '1993',
        url: 'http://author.com',
        author: {
          id: 3,
          name: 'Max Giovanna'
        },
        title: 'The Adventures of Anonymous',
        price: 430,
        rating: 2.8
      },
      {
        id: 5,
        year: '2003',
        url: 'http://author.com',
        author: {
          id: 4,
          name: 'Christy Lawson'
        },
        title: 'Fact versus Fiction',
        price: 120,
        rating: 3.3
      },
      {
        id: 6,
        year: '2003',
        url: 'http://author.com',
        author: {
          id: 7,
          name: 'Arisha Parks'
        },
        title: 'An exploration of Memes',
        price: 120,
        rating: 1.3
      }
    ];

    this.initializePage();
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
      return this.colorSchemeOrange;
    }
    if (sum === 1) {
      return this.colorSchemeGreen;
    }
    if (sum === 2) {
      return this.colorSchemeBlue;
    }
  }

  onScroll() {
    this.isLoading = true;
    setTimeout(() => {
      this.bookList.push({
        id: 2,
        year: '2015',
        url: 'http://author.com',
        author: {
          id: 1,
          name: 'John Doe'
        },
        title: 'TIME MANAGEMENT',
        price: 100,
        rating: 3.5
      });
      this.bookList.push({
        id: 3,
        year: '2018',
        url: 'http://author.com',
        author: {
          id: 2,
          name: 'Harry Graham Thornton'
        },
        title: 'The Big, White Bear',
        price: 312,
        rating: 4.7
      });
      this.initializePage();
      this.isLoading = false;
    }, 3000);

  }

  redirectToHome() {
    this.router.navigate(['/home']);
  }
}

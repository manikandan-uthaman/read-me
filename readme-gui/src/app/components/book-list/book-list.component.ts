import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit {

  bookList;
  rows;
  constructor() { }

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
        title: 'The Amazing Adventures of Anonymous',
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
      },{
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
        title: 'The Amazing Adventures of Anonymous',
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
      },{
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
        title: 'The Amazing Adventures of Anonymous',
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
    const rowCount = Math.ceil(this.bookList.length / 2);
    for (let index = 0; index < rowCount; index++) {
      this.rows.push(this.bookList.splice(0, 2));
    }
  }

}

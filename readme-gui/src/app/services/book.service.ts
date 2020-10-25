import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {environment} from 'src/environments/environment';
import { Observable } from 'rxjs';
import { SearchResponse } from '../model/search-response';
import { BookSearchRequest } from '../model/search-request';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private _httpClient: HttpClient) { }

  getBookList(searchRequest: BookSearchRequest): Observable<SearchResponse> {
    return this._httpClient.post<SearchResponse>(environment.context + '/books/search', searchRequest);
  }
}

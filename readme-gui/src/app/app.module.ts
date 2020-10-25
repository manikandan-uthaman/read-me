import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { BookListComponent } from './components/book-list/book-list.component';
import { CardComponent } from './components/card/card.component';
import { ObserveVisibilityDirective } from './directive/observe-visibility.directive';
import { SpinnerComponent } from './components/spinner/spinner.component';
import { HomeIconComponent } from './components/home-icon/home-icon.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    BookListComponent,
    CardComponent,
    ObserveVisibilityDirective,
    SpinnerComponent,
    HomeIconComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

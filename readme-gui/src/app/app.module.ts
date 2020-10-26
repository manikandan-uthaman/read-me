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
import { BookDetailsComponent } from './components/book-details/book-details.component';
import { HeadingComponent } from './components/heading/heading.component';
import { MenuComponent } from './components/menu/menu.component';
import { ToastrComponent } from './components/toastr/toastr.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    BookListComponent,
    CardComponent,
    ObserveVisibilityDirective,
    SpinnerComponent,
    BookDetailsComponent,
    HeadingComponent,
    MenuComponent,
    ToastrComponent
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

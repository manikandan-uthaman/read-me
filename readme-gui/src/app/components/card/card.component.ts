import { Component, OnInit, Input, HostBinding } from '@angular/core';
import { ColorScheme } from 'src/app/model/color-schemes';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {

  @Input() book;
  @Input() colorScheme = ColorScheme.colorSchemeOrange;

  constructor() { }

  ngOnInit(): void {
  }

}

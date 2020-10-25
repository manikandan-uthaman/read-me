import { Component, OnInit, Input, HostBinding } from '@angular/core';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {

  @Input() book;
  @Input() colorScheme = {
    lightHex: '#ffb900',
    lightRgb: '255,185,0',
    darkHex: '#ff7730',
    darkRgb: '255,119,48'
  };

  constructor() { }

  ngOnInit(): void {
  }

}

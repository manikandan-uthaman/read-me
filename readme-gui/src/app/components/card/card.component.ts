import { Component, OnInit, Input, HostBinding } from '@angular/core';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {

  @Input() book;
  @Input() colorScheme = 'primary';

  constructor() { }

  ngOnInit(): void {
  }

}

import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  @Input() items: Array<string> = [];
  @Output() clicked = new EventEmitter<string>();

  constructor() { }

  ngOnInit(): void {
  }

  showIcon(name: string): boolean {
    return (this.items.indexOf(name) > -1);
  }

  emitEvent(name: string) {
    this.clicked.emit(name);
  }

}

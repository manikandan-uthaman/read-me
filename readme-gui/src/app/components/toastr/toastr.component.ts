import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'src/app/services/toastr.service';

@Component({
  selector: 'app-toastr',
  templateUrl: './toastr.component.html',
  styleUrls: ['./toastr.component.scss']
})
export class ToastrComponent implements OnInit {

  messages: Array<any> = [];
  timeToLive: number = 5;
  constructor(private toastrService: ToastrService) { }

  ngOnInit(): void {
    this.toastrService.messageChannel.subscribe(msg => {
      this.addMessage(msg);
    });
  }

  addMessage(msg) {
    this.messages.push(msg);
    setTimeout(() => {
      this.removeMessage(this.messages);
    }, (this.timeToLive * 1000));
  }

  removeMessage(msg) {
    this.messages.splice(this.messages.indexOf(msg), 1);
  }
}

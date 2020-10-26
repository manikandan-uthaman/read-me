import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ToastrService {

  subject;
  messageChannel;
  message;
  constructor() {
    this.subject = new BehaviorSubject({});
    this.messageChannel = this.subject.asObservable();
  }

  showSuccess(msg: string) {
    this.addMessage(msg, 'success');
  }

  showError(msg: string) {
    this.addMessage(msg, 'error');
  }

  showInfo(msg: string) {
    this.addMessage(msg, 'info');
  }

  addMessage(msg: string, type: string) {
    this.subject.next({
      type: type,
      text: msg
    });
  }
}

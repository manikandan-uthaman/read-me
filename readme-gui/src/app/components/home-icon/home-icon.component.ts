import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'home-icon',
  templateUrl: './home-icon.component.html',
  styleUrls: ['./home-icon.component.scss']
})
export class HomeIconComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  redirectToHome() {
    this.router.navigate(['/home']);
  }
}

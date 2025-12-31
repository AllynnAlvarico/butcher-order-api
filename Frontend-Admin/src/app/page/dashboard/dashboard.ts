import { Component } from '@angular/core';
import {Sidepanel} from './sidepanel/sidepanel';

@Component({
  selector: 'app-dashboard',
  imports: [
    Sidepanel
  ],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css',
})
export class Dashboard {

}

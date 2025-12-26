import { Component } from '@angular/core';
import {Links} from './links/links';

@Component({
  selector: 'app-nav',
  imports: [
    Links
  ],
  templateUrl: './nav.html',
  styleUrl: './nav.css',
})
export class Nav {

}

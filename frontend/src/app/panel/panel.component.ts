import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-panel',
  templateUrl: './panel.component.html',
  styleUrls: ['./panel.component.css']
})
export class PanelComponent implements OnInit {

  imageUrlArray: Array<string> = ['assets/head.jpg', 'assets/eclipse_cross.jpg', 'assets/L200-DC-Handling.jpg',
                                  'assets/L200-DC-Performance-02.jpg'];

  constructor() {
  }

  ngOnInit() {
  }

}

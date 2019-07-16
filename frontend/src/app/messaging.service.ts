import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MessagingService {

  private _message: any;
  private _info1: any;
  private _info2: any;

  constructor() { }

  get message(): any {
    return this._message;
  }

  set message(value: any) {
    this._message = value;
  }

  get info1(): any {
    return this._info1;
  }

  set info1(value: any) {
    this._info1 = value;
  }

  get info2(): any {
    return this._info2;
  }

  set info2(value: any) {
    this._info2 = value;
  }
}

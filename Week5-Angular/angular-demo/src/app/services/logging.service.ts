import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoggingService {

  constructor() { }

  log(message: string):void{
    console.log(new Date() + message);
  }

  warn(message: string): void{
    console.warn(new Date() + message);
  }

}

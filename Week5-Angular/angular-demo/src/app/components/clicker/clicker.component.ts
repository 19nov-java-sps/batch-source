import { Component, OnInit } from '@angular/core';
import { LoggingService } from 'src/app/services/logging.service';

@Component({
  selector: 'app-clicker',
  templateUrl: './clicker.component.html',
  styleUrls: ['./clicker.component.css']
})
export class ClickerComponent implements OnInit {

  count:number = 0;
  counterColorClass: string = "blue-text";

  constructor(private logger: LoggingService) { }

  ngOnInit() {
  }

  increment(value: number){
    if(value==1){
      this.logger.log("incrementing by 1");
    } else if (value==5){
      this.logger.warn("incrementing by 5");
    }

    this.count += value;
    if(this.count%5==0){
      this.counterColorClass = "red-text";
    } else {
      this.counterColorClass = "blue-text";
    }
  }

}

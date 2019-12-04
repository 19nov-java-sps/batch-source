import { Component } from '@angular/core';

@Component({
    selector: 'app-databinding',
    templateUrl: './databinding.component.html'
})
export class DatabindingComponent{

    person1 = {name: "Holly", age: 32, email: "jollyholly@gmail.com"};
    person2 = {name: "Paul", age:45, email: "pauljenkins@gmail.com"};

}
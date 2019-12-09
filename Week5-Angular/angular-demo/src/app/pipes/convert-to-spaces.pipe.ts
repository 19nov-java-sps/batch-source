import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'convertToSpaces'
})
export class ConvertToSpacesPipe implements PipeTransform {

  transform(value: string, character?: any): string {
  if(character===undefined){
    character = '-';
  }
    for(let i=0; i<value.length; i++){
      if(value.charAt(i)===character){
        value = value.substring(0,i)+" "+value.substring(i+1);
      }
    }
    return value;
  }

}

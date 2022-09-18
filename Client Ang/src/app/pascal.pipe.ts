import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'pascal'
})
export class PascalPipe implements PipeTransform {
// first one is primary value , then list and at last: after is return type
//{{"hello" | Pascal}} spo here that hello goes as parameter and righ now it will just
//  print Pascal as we are just rteurning string pascal
 
transform(value: String, ...args: unknown[]): String {

   
    var finished =" ";
   const arr = value.split(" ");

   for(var i =0; i<arr.length;i++){
      arr[i] = arr[i].charAt(0).toUpperCase() + arr[i].substring(1) ; 
     finished +=arr[i]+" ";
    }
    
  //  finished = arr.join(" ");
   return finished;
 
}}

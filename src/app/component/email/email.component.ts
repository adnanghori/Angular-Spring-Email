import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Subject } from 'rxjs';
import { EmailService } from 'src/app/service/email.service';

@Component({
  selector: 'app-email',
  templateUrl: './email.component.html',
  styleUrls: ['./email.component.css']
})
export class EmailComponent implements OnInit {
  data={
    to:"",
    subject:"",
    message:""
  } 
  flag:boolean = false;
   constructor(private snack:MatSnackBar , private service:EmailService) { }
   

  
  ngOnInit(): void {
  }
  btnClick(){
    console.log("button clicked");
    this.snack.open("Welcome to this app","Cancel");
  }

    doSubmitForm(){
      console.log("working");
      
      if(this.data.to==''||this.data.subject==''||this.data.message==''){
        this.snack.open("Fields are Empty");
      }
      this.flag= true;
      this.service.sendEmail(this.data).subscribe(
        
        response=>{
          console.log(response);
          this.flag=false
          this.snack.open("success","Cancel");
          
        },
        error=>{
          console.log("error");
          this.flag = false;
          
        }
      )
    }

}
import { Component, OnInit } from '@angular/core';
import { Client } from '../client';

@Component({
  selector: 'app-client-form',
  templateUrl: './client-form.component.html',
  styleUrls: ['./client-form.component.css']
})
export class ClientFormComponent implements OnInit {


client: Client;
name: string = 'Batman';

  constructor() {
  this.client = new Client();
  this.client.name = 'Batman II';
   }

  ngOnInit(): void {
  }

clicar(){
    console.log('clicked');
}


}

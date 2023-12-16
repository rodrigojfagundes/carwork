import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from '../client';
import { ClientService } from 'src/app/client.service';

@Component({
    selector: 'app-client-list',
    templateUrl: './client-list.component.html',
    styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {

    clients: Client[] = [];
    clientSelected: Client;
    messageSuccess: string;
    messageError: string;


    constructor(
        private service: ClientService,
        private router: Router) { }



    ngOnInit(): void {
        this.service
            .findAll()
            .subscribe(response => this.clients = response);
    }

    newRegister() {
        this.router.navigate(['/client/form'])
    }

    prepareDelete(client: Client) {
        this.clientSelected = client;
    }

    deleteClient() {
        this.service
            .delete(this.clientSelected)
            .subscribe(response => {
                this.messageSuccess = 'Client has been delete with sucess'
                this.ngOnInit();
            },
                error => this.messageError = 'Error in delete client'
            )

    }


}


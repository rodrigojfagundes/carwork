import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { Client } from '../client';
import { ClientService } from 'src/app/client.service';
import { Observable } from 'rxjs';
import { from } from 'rxjs';

@Component({
    selector: 'app-client-form',
    templateUrl: './client-form.component.html',
    styleUrls: ['./client-form.component.css']
})
export class ClientFormComponent implements OnInit {


    client: Client;
    success: boolean = false;
    errors: String[];
    id: number;

    constructor(
        private service: ClientService,
        private router: Router,
        private activatedRoute: ActivatedRoute
    ) {
        this.client = new Client();
    }

    ngOnInit(): void {

        let params: Observable<Params> = this.activatedRoute.params
        params.subscribe(urlParams => {

            this.id = urlParams['id'];
            if (this.id) {
                this.service.findById(this.id)
                    .subscribe(response => this.client = response,
                        errorResponse => this.client = new Client())
            }
        })
    }

    returnToList() {
        this.router.navigate(['/client-list'])
    }

    onSubmit() {
        if (this.id) {
            this.service
                .update(this.client)
                .subscribe(response => {
                    this.success = true;
                    this.errors = null;
                },
                    errorRespose => {
                        this.errors = ['Error update the client']
                    })
        } else {
            this.service.insert(this.client)
                .subscribe(response => {
                    this.success = true;
                    this.errors = null;
                    this.client = response;
                }, errorResponse => {
                    this.success = false;
                    this.errors = errorResponse.error.errors;
                }


                )
        }
    }


}

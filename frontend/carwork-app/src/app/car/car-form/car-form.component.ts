import { Component, OnInit } from "@angular/core";
import { Client } from "src/app/client/client";
import { ClientService } from "src/app/client.service";
import { Car } from "../car";
import { CarService } from "src/app/car.service";


@Component({
    selector: 'app-car-form',
    templateUrl: './car-form.component.html',
    styleUrls: ['./car-form.component.css']
})

export class CarFormComponent implements OnInit {

    clients: Client[] = [];
    car: Car;
    success: boolean = false;
    errors: String[];


    constructor(
        private clientService: ClientService,
        private service: CarService
    ) {
        this.car = new Car();
    }

    ngOnInit(): void {
        this.clientService
            .findAll()
            .subscribe(response =>
                this.clients = response);
            }
    

    onSubmit() {
        this.service
            .insert(this.car)
            .subscribe(response =>
            {this.success = true;
            this.errors = null;
            this.car = new Car();
            }, errorResponse => {
            this.success = false;
            this.errors = errorResponse.error.errors;
            }
            )

    }




}

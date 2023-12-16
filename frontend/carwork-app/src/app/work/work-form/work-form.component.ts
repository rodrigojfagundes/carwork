import { Component, OnInit } from "@angular/core";
import { Car } from "src/app/car/car";
import { CarService } from "src/app/car.service";
import { Work } from "../work";
import { WorkService } from "src/app/work.service";


@Component({
    selector: 'app-work-form',
    templateUrl: './work-form.component.html',
    styleUrls: ['./work-form.component.css']
})

export class WorkFormComponent implements OnInit {

    cars: Car[];
    work: Work;
    success: boolean = false;
    errors: String[];

    constructor(
        private carService: CarService,
        private service: WorkService
    ) {
        this.work = new Work();
    }

    ngOnInit(): void {
        this.carService
            .findAll()
            .subscribe(data => {
                this.cars = data.content;
            })
    }


    onSubmit() {
        this.service
            .insert(this.work)
            .subscribe(response => {
                this.success = true;
                this.errors = null;
                this.work = new Work();
            }, errorResponse => {
                this.success = false;
                this.errors = errorResponse.error.errors;
            })
    }
}
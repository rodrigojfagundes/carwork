import { Component, OnInit } from "@angular/core";
import { CarSearch } from "./carSearch";
import { CarService } from "src/app/car.service";
import { Car } from "../car";

@Component({
    selector: 'app-car-list',
    templateUrl: './car-list.component.html',
    styleUrls: ['./car-list.component.css']
})

export class CarListComponent implements OnInit {

    model: string;
    plate: string;
    cars: Car[];
    message: string;

    constructor(
        private service: CarService
    ) { }


    ngOnInit(): void {
        this.service.findAll()
        .subscribe(data => {this.cars = data.content})
    }

consult(){}

}


import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Car } from "./car/car";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { CarSearch } from './car/car-list/carSearch';
import { ResponsePageable } from "./car/responsePageable.model";


@Injectable({
    providedIn: 'root'
})

export class CarService {

    apiURL: string = environment.apiUrlBase + "/cars";

    constructor(private http: HttpClient) { }

    insert(car: Car): Observable<Car> {
        return this.http.post<Car>('http://localhost:8080/cars', car);
    }

    findAll(): Observable<ResponsePageable> {
        return this.http.get<ResponsePageable>('http://localhost:8080/cars');

    }


}


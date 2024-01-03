import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Work } from "./work/work";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";
import { ResponsePageable } from "./car/responsePageable.model";

@Injectable({
    providedIn: 'root'
})

export class WorkService {

    apiURL: string = environment.apiUrlBase + "/works";
    constructor(private http: HttpClient) { }

    insert(work: Work): Observable<Work> {
        return this.http.post<Work>(this.apiURL, work);
    }

    findAll(): Observable<Work[]> {
        const httpParams = new HttpParams();
        const url = this.apiURL;
        return this.http.get<Work[]>(this.apiURL);
    }


}
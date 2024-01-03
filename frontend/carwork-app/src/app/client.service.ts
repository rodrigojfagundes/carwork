import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Client } from "./client/client";
import { Observable } from "rxjs";
import { environment } from "src/environments/environment";

@Injectable({
    providedIn: 'root'
})

export class ClientService {


    apiURL: string = environment.apiUrlBase + "/clients";


    httpOptions = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json'
        })
    };


    constructor(private http: HttpClient) { }

    insert(client: Client): Observable<Client> {
        return this.http.post<Client>(`${this.apiURL}`, client);
    }

    update(client: Client): Observable<any> {
        return this.http.put<Client>(`${this.apiURL}/${client.id}`, client);
    }

    findAll(): Observable<Client[]> {
        return this.http.get<Client[]>(this.apiURL);
    }

    findById(id: number): Observable<any> {
        return this.http.get<Client>(`${this.apiURL}/${id}`);
    }

    delete(client: Client): Observable<any> {
        return this.http.delete<any>(`${this.apiURL}/${client.id}`);
    }

}
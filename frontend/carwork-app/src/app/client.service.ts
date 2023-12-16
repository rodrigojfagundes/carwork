import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Client } from "./client/client";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})

export class ClientService {

    httpOptions = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json'
        })
    };


    constructor(private http: HttpClient) { }

    insert(client: Client): Observable<Client> {
        return this.http.post<Client>('http://localhost:8080/clients', client);
    }

    update(client: Client): Observable<any> {
        return this.http.put<Client>(`http://localhost:8080/clients/${client.id}`, client);
    }

    findAll(): Observable<Client[]> {
        return this.http.get<Client[]>('http://localhost:8080/clients');
    }

    findById(id: number): Observable<any> {
        return this.http.get<Client>(`http://localhost:8080/clients/${id}`);
    }

    delete(client: Client): Observable<any> {
        return this.http.delete<any>(`http://localhost:8080/clients/${client.id}`);
    }

}
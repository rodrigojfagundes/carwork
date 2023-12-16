import { Component, OnInit } from "@angular/core";
import { WorkService } from "src/app/work.service";
import { Work } from "../work";

@Component({
    selector: 'app-work-list',
    templateUrl: './work-list.component.html',
    styleUrls: ['./work-list.component.css']
})
export class WorkListComponent implements OnInit {

    works: Work[] = [];
    message: string;

    constructor(
        private service: WorkService
    ) { }

    ngOnInit(): void {
        this.service.findAll()
            .subscribe(response => {
                this.works = response;
                if (this.works.length <= 0) {
                    this.message = "No works find";
                } else {
                    this.message = null;
                }
            })
    }

    Consult(){}


}
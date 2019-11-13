import { ReceipeDetailsComponent } from '../receipe-details/receipe-details.component';
import { Observable } from "rxjs";
import { ReceipeService } from "../receipe.service";
import { Receipe } from "../receipe";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: "app-receipe-list",
  templateUrl: "./receipe-list.component.html",
  styleUrls: ["./receipe-list.component.css"]
})
export class ReceipeListComponent implements OnInit {
  receipes: Observable<Receipe[]>;

  constructor(private receipeService: ReceipeService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.receipes = this.receipeService.getReceipesList();
  }

  deleteReceipe(id: number) {
    this.receipeService.deleteReceipe(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  receipeDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateReceipe(id: number){
    this.router.navigate(['update', id]);
  }
}

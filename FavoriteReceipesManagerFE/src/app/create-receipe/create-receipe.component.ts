import { ReceipeService } from '../receipe.service';
import { Receipe } from '../receipe';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-receipe',
  templateUrl: './create-receipe.component.html',
  styleUrls: ['./create-receipe.component.css']
})
export class CreateReceipeComponent implements OnInit {

  receipe: Receipe = new Receipe();
  submitted = false;

  constructor(private receipeService: ReceipeService,
    private router: Router) { }

  ngOnInit() {
  }

  newReceipe(): void {
    this.submitted = false;
    this.receipe = new Receipe();
  }

  save() {
    this.receipeService.createReceipe(this.receipe)
      .subscribe(data => console.log(data), error => console.log(error));
    this.receipe = new Receipe();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['receipes']);
  }
}

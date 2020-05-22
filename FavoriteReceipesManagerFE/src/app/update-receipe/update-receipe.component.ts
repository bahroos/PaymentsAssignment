import { Component, OnInit } from '@angular/core';
import { Receipe } from '../receipe';
import { ActivatedRoute, Router } from '@angular/router';
import { ReceipeService } from '../receipe.service';

@Component({
  selector: 'app-update-receipe',
  templateUrl: './update-receipe.component.html',
  styleUrls: ['./update-receipe.component.css']
})
export class UpdateReceipeComponent implements OnInit {

  id: number;
  receipe: Receipe;

  constructor(private route: ActivatedRoute,private router: Router,
    private receipeService: ReceipeService) { }

  ngOnInit() {
    this.receipe = new Receipe();

    this.id = this.route.snapshot.params['id'];

    this.receipeService.getReceipe(this.id)
      .subscribe(data => {
        console.log(data)
        this.receipe = data;
      }, error => console.log(error));
  }

  updateReceipe() {
    this.receipeService.updateReceipe(this.id, this.receipe)
      .subscribe(data => console.log(data), error => console.log(error));
    this.receipe = new Receipe();
    this.gotoList();
  }

  onSubmit() {
    this.updateReceipe();
  }

  gotoList() {
    this.router.navigate(['https://dhirajappservice01.azurewebsites.net/receipes']);
  }
}

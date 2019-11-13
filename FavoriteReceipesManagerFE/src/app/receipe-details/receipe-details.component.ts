import { Receipe } from '../receipe';
import { Component, OnInit, Input } from '@angular/core';
import { ReceipeService } from '../receipe.service';
import { ReceipeListComponent } from '../receipe-list/receipe-list.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-receipe-details',
  templateUrl: './receipe-details.component.html',
  styleUrls: ['./receipe-details.component.css']
})
export class ReceipeDetailsComponent implements OnInit {

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

  list(){
    this.router.navigate(['receipes']);
  }
}

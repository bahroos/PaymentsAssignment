import { ReceipeDetailsComponent } from './receipe-details/receipe-details.component';
import { CreateReceipeComponent } from './create-receipe/create-receipe.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ReceipeListComponent } from './receipe-list/receipe-list.component';
import { UpdateReceipeComponent } from './update-receipe/update-receipe.component';

const routes: Routes = [
  { path: '', redirectTo: 'receipe', pathMatch: 'full' },
  { path: 'receipes', component: ReceipeListComponent },
  { path: 'add', component: CreateReceipeComponent },
  { path: 'update/:id', component: UpdateReceipeComponent },
  { path: 'details/:id', component: ReceipeDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

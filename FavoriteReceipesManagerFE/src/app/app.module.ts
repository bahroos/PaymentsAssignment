import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateReceipeComponent } from './create-receipe/create-receipe.component';
import { ReceipeDetailsComponent } from './receipe-details/receipe-details.component';
import { ReceipeListComponent } from './receipe-list/receipe-list.component';
import { HttpClientModule } from '@angular/common/http';
import { UpdateReceipeComponent } from './update-receipe/update-receipe.component';
@NgModule({
  declarations: [
    AppComponent,
    CreateReceipeComponent,
    ReceipeDetailsComponent,
    ReceipeListComponent,
    UpdateReceipeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

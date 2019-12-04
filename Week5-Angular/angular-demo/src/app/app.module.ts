import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FirstComponent } from './components/first/first.component';
import { DatabindingComponent } from './components/databinding/databinding.component';
import { ClickerComponent } from './components/clicker/clicker.component';
import { SDirectivesComponent } from './components/s-directives/s-directives.component';
import { ADirectivesComponent } from './components/a-directives/a-directives.component';
import { PipeDemoComponent } from './components/pipe-demo/pipe-demo.component';
import { ConvertToSpacesPipe } from './pipes/convert-to-spaces.pipe';
import { LoggingService } from './services/logging.service';
import { NavComponent } from './components/nav/nav.component';
import { DirectivesComponent } from './components/directives/directives.component';

@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    DatabindingComponent,
    ClickerComponent,
    SDirectivesComponent,
    ADirectivesComponent,
    PipeDemoComponent,
    ConvertToSpacesPipe,
    NavComponent,
    DirectivesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    LoggingService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

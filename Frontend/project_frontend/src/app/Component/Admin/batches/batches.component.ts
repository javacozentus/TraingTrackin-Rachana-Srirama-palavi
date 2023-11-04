import { Component, OnInit } from '@angular/core';
import { ViewChild, ViewContainerRef } from '@angular/core';

import { BatchtableComponent } from '../batchtable/batchtable.component';

@Component({
  selector: 'app-batches',
  templateUrl: './batches.component.html',
  styleUrls: ['./batches.component.css'],
})
export class BatchesComponent implements OnInit {
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

//   @ViewChild('container3', { read: ViewContainerRef, static: true })
//   container3!: ViewContainerRef;

//   onAddBatch() {
//     this.container3.clear();

//     this.container3.createComponent(BatchtableComponent);
//   }

//   toggleForm() {
//     this.var1 = false;

//     this.var2 = false;
//   }

//   var1 = true;

//   var2 = true;
// }
@ViewChild('container3', { read: ViewContainerRef, static: true })
container3!: ViewContainerRef;

onAddBatch() {
  this.container3.clear();

  this.container3.createComponent(BatchtableComponent);
}

toggleForm() {
  this.var1 = false;

  this.var2 = false;
}

var1 = true;

var2 = true;
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StackService {

  private url: string = window["env"]["apiUrl"] + "/stack";

  private stack: number[] | undefined;

  constructor(
    protected http: HttpClient
    ) { }

  get() {
    // let url = this.url;
    // return this.http.post<StackDTO>(url);
  }

  push(value: number) {
    let url = this.url + "/push/" + value;
    return this.http.post<StackDTO>(url, value).toPromise().then((res) => {
      this.stack = res.stack;
    });
  }

  pop() {
    let url = this.url + "/pop";
    return this.http.get<PopDTO>(url).toPromise().then((res) => {
      this.stack = res.stack;
    });
  }
}

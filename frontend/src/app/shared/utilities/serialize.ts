import { HttpParams, HttpUrlEncodingCodec } from '@angular/common/http';
import { looseInvalid } from './loose-invalid';

export function serialize(obj: any): HttpParams {
  let params = new HttpParams();

  // let objString = JSON.stringify(obj);
  // let objParams = objString.substring(1, objString.length - 1).split('&');
  // for (const k in objParams){
  //   let prop = objParams[k];
  //   let index = prop.search('=');
  //   let key = prop.substring(0, index);
  //   let value = prop.substring(index + 1, prop.length);
  //   if (!looseInvalid(value)){
  //     params = params.set(key, value);
  //   }
  // }

  for (const key in obj) {
    if (obj.hasOwnProperty(key) && !looseInvalid(obj[key])) {
      console.log(key + ":" + obj[key])
      params = params.set(key, obj[key]);
    }
  }

  return params;
}

import {name,age,gender,say} from "./export1"

console.log(name,age,gender);
// name="test";
say("hello rjw");

import {name as a,age as b,gender as c,say as s} from "./export1"
console.log(a);
say("hello,nodejs")
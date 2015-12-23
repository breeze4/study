/**
 * Created by Aniara on 11/28/2015.
 */

/**
 Implement function foo which takes an integer size, and returns an array of that size where each element in that array
 is a function that returns the index of that function in the array.

 Testcase: 42 === foo(1000)[42]()

 */

function foo(size) {
    var result = [size];
    function createInnerFn(index) {
        return function innerFn() {
            return index;
        };
    }
    for(var i = 0; i < size; i++) {
        result[i] = createInnerFn(i);
    }
    return result;
}

function test42() {
    var actual = foo(1000)[42]();
    console.log('expected:', 42, ', actual:', actual);
}
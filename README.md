# percolation
https://sp23.datastructur.es/materials/hw/hw2/


## The Problem 

Given a composite systems comprised of randomly distributed insulating and metallic materials: what fraction of the materials need to be metallic so that the composite system is an electrical conductor? Given a porous landscape with water on the surface (or oil below), under what conditions will the water be able to drain through to the bottom (or the oil to gush through to the surface)?


## Challenges 

I was fascinated by and learned a lot when solving the problem of "backwash". By using just one union-find data structure that using a virtual top and bottom site didn't seem to work. The approach with two virtual sites seems to be the best one when it comes to understand if a system percolates or not. With this approach we will have a nearly constant runtime. Without the two nodes we would need to loop for each site at the bottom sites and check the connection for each top site thus resulting in linear runtime performance. 

The backwash problem can be solved with the aid of a mirror union-find data structure that differs from the main one because it misses the bottom virtual site. This prevents all the site at the bottom to be virtually connected with each other thus preventing backwash when the system does indeed percolate.


## Assessment Summary 

Compilation: PASSED
Style: PASSED
Findbugs: No potential bugs found.
API: PASSED

Correctness: 26/26 tests passed
Memory: 8/8 tests passed
Timing: 9/9 tests passed

Aggregate score: 96.25% [Correctness: 65%, Memory: 10%, Timing: 25%, Style: 0%]


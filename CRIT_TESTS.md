After brief analysis as most critical tests cases were chosen tests from next categories: 
1. Cases that will affect main application infrastructure
    1. API availability
    2. Agents availability
    3. VCS availability
    4. Authentication availability
2. Cases that will affect common use cases
    1. CRUD test for main entities (Projects, Pools and so on)
    2. Ability to execute builds and test suits execution

To cover at this particular task 3 test cases were chosen:
1. API availability
    This case will allow us to check: 
    a) heartbeat of system itself after TC server start. 
    b) token authentication (positive case).
    c) based on "fail fast" approach will highlight common problem and save time on test execution.
2. Agents availability
    This case will allow us to check: 
    a) health of TC critical infrastructure related with automatic server-agent connection
3.  Projects creation
    This case will allow us to check:
    a) creation of one of the common entities of application
    b) API functionality related with json/xml REST requests exchange
    c) Application integration with an inner DB and filesystem 
    

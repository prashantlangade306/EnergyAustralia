# EnergyAustralia

This application code contains the solution developed for the below problem statement as part of recuitment process at Energy Australia for the position of Digital Developer.

Your team is tasked with listing out music festival data in a particular manner: at the top level, it should show the band record label, below that it should list out all bands under their management, and below that it should display which festivals they've attended, if any. All entries should be sorted alphabetically.

For example:

Record Label 1
Band X
Omega Festival
Band Y
Record Label 2
Band A
Alpha Festival
Beta Festival

Solution Approach:

The solution is developed using Intellij IDE by using Java8 features. 

The approach of the solution contains below steps at high level.

1. Consume the rest api provided for fetching the API response.
2. Get unique record labels from the list that needs to be displayed at the top.
3. Prepare recordLabel to band name list map.
4. Sort the map based on the keys
5. Print the map in the required order.

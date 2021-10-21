# String converter

## Project description
It is a Java console converter application that can take a String representing match time in one format, and convert it to a String representing match time in another format.It can read the supplied test data file and output the result to the command line.

## Examples

| Input            | Expected Output              |
| -------------    | -------------                |
| "[PM] 0:00.000"  | "00:00 – PRE_MATCH"          |
| "[H1] 0:15.025"  | "00:15 – FIRST_HALF"         |
| "[H1] 3:07.513"  | "03:08 – FIRST_HALF          |
| "[H1] 45:00.001" | "45:00 +00:00 – FIRST_HALF"  |
| "[H1] 46:15.752" | "45:00 +01:16 – FIRST_HALF"  |
| "[HT] 45:00.000" | "45:00 – HALF_TIME"          |
| "[H2] 45:00.500" | "45:01 – SECOND_HALF"        |
| "[H2] 90:00.908" | "90:00 +00:01 – SECOND_HALF" |
| "[FT] 90:00.000" | "90:00 – FULL_TIME"          |
| "90:00"          | "INVALID"                    |
| "[H3] 90:00.000" | "INVALID"                    |
| "[PM] -10:00.000"| "INVALID"                    |
| "FOO"            | "INVALID"                    |

## Design, diagram, structure

## Used tech, requirements

## Installation

## Usage

## Testing

Logging? Demo? Approaches used ...

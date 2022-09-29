#import Pkg; Pkg.add("Pluto");
#import Pluto; Pluto.run();

1:10 |> (x -> filter(iseven,x)) |> length
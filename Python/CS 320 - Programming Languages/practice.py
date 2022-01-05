
def first(rise, fall):
  def second(data):
    print( rise + ':' + data + ":" + fall )
  return second

third = first("water", "stone")
print(third("grinds"))
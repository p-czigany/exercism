class LocomotiveEngineer
  def self.generate_list_of_wagons(*wagon_ids)
    wagon_ids
  end

  def self.fix_list_of_wagons(each_wagons_id, missing_wagons)
    return each_wagons_id[2], *missing_wagons, *each_wagons_id[3..], *each_wagons_id[..1]
  end

  def self.add_missing_stops(route, **stops)
    route.merge({ :stops => stops.values })
  end

  def self.extend_route_information(route, more_route_information)
    route.merge(more_route_information)
  end
end
